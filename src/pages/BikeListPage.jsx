import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

// Updated bike data with deposit fixed to ₹500
const bikes = [
  { id: 1, name: "Honda CB Unicorn 150", basePrice: 599, img: "/bikes/splender.jpg", type: "Manual", seating: "2-Seater", fuel: "Petrol", deposit: 500, makeYear: 2018, locations: ["Hadapsar", "Wakad"] },
  { id: 2, name: "Honda Activa 5G", basePrice: 399, img: "/bikes/activai.jpg", type: "Automatic", seating: "2-Seater", fuel: "Petrol", deposit: 500, makeYear: 2019, locations: ["Wakad", "Kothrud"] },
  { id: 3, name: "TVS Jupiter", basePrice: 299, img: "/bikes/jupiter.jpg", type: "Automatic", seating: "2-Seater", fuel: "Petrol", deposit: 500, makeYear: 2020, locations: ["Kothrud", "Hadapsar"] },
  { id: 4, name: "Royal Enfield Classic 350", basePrice: 999, img: "/bikes/activa.jpg", type: "Manual", seating: "2-Seater", fuel: "Petrol", deposit: 500, makeYear: 2017, locations: ["Wakad"] },
  { id: 5, name: "Bajaj Pulsar 150", basePrice: 499, img: "/bikes/pulsar.jpg", type: "Manual", seating: "2-Seater", fuel: "Petrol", deposit: 500, makeYear: 2021, locations: ["Kothrud", "Hadapsar"] },
];

const BikeList = () => {
  const navigate = useNavigate();
  const [filteredBikes, setFilteredBikes] = useState(bikes);
  const [selectedFilters, setSelectedFilters] = useState({ transmissionType: [], fuelType: [], location: "" });
  const [sortOrder, setSortOrder] = useState("");

  const toggleFilter = (filterArray, value) =>
    filterArray.includes(value) ? filterArray.filter((item) => item !== value) : [...filterArray, value];

  const updateFilters = (filterType, value) => {
    const newFilters = { ...selectedFilters };
    if (filterType === "transmissionType") newFilters.transmissionType = toggleFilter(newFilters.transmissionType, value);
    else if (filterType === "fuelType") newFilters.fuelType = toggleFilter(newFilters.fuelType, value);
    else if (filterType === "location") newFilters.location = value;
    setSelectedFilters(newFilters);
    applyFilters(newFilters, sortOrder);
  };

  const sortBikes = (order) => {
    setSortOrder(order);
    applyFilters(selectedFilters, order);
  };

  const applyFilters = (filters, order) => {
    let result = bikes;
    if (filters.transmissionType.length > 0) result = result.filter((bike) => filters.transmissionType.includes(bike.type));
    if (filters.fuelType.length > 0) result = result.filter((bike) => filters.fuelType.includes(bike.fuel));
    if (filters.location) result = result.filter((bike) => bike.locations.includes(filters.location));
    if (order === "asc") result = result.sort((a, b) => a.basePrice - b.basePrice);
    if (order === "desc") result = result.sort((a, b) => b.basePrice - a.basePrice);
    setFilteredBikes(result);
  };

  return (
    <div className="container mx-auto py-6 border-6 flex flex-col lg:flex-row">
      {/* Filter Section */}
      <aside className="w-full lg:w-1/4 bg-gray-100 p-4 -lg mb-6 lg:mb-0">
        <h3 className="text-lg font-bold mb-4 text-gray-900">Filters</h3>
        <div className="mb-6">
          <h4 className="font-semibold mb-2 text-sm text-gray-700">Transmission Type</h4>
          <label className="flex items-center mb-2 text-sm">
            <input type="checkbox" className="mr-2" onChange={() => updateFilters("transmissionType", "Manual")} /> Gear
          </label>
          <label className="flex items-center text-sm">
            <input type="checkbox" className="mr-2" onChange={() => updateFilters("transmissionType", "Automatic")} /> Gearless
          </label>
        </div>
        <div className="mb-6">
          <h4 className="font-semibold mb-2 text-sm text-gray-700">Fuel Type</h4>
          <label className="flex items-center mb-2 text-sm">
            <input type="checkbox" className="mr-2" onChange={() => updateFilters("fuelType", "Petrol")} /> Petrol
          </label>
          <label className="flex items-center text-sm">
            <input type="checkbox" className="mr-2" onChange={() => updateFilters("fuelType", "Electric")} /> Electric
          </label>
        </div>
        <div className="mb-6">
          <h4 className="font-semibold mb-2 text-sm text-gray-700">Location</h4>
          <select
            className="w-full p-3 border-2 border-gray-300 bg-white text-gray-700 text-sm transition-all duration-300 ease-in-out transform hover:scale-105 focus:ring-2 focus:outline-none"
            onChange={(e) => updateFilters("location", e.target.value)}
          >
            <option value="">All</option>
            <option value="Hadapsar">Hadapsar</option>
            <option value="Wakad">Wakad</option>
            <option value="Kothrud">Kothrud</option>
          </select>
        </div>
        <div className="mb-6">
          <h4 className="font-semibold mb-2 text-sm text-gray-700">Sort By Price</h4>
          <button className="block w-full mb-2 p-2 bg-orange-300 text-white" onClick={() => sortBikes("asc")}>
            Low to High
          </button>
          <button className="block w-full p-2 bg-orange-300 text-white" onClick={() => sortBikes("desc")}>
            High to Low
          </button>
        </div>
      </aside>

      {/* Bike Listing */}
      <main className="w-full lg:w-3/4 pl-0 lg:pl-6">
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 xl:grid-cols-4 gap-6">
          {filteredBikes.map((bike) => (
            <div key={bike.id} className="bg-white border p-4 shadow-md hover:shadow-xl transition-shadow">
              <img src={bike.img} alt={bike.name} className="w-full h-40 object-cover rounded-t-lg" />
              <h3 className="text-base font-medium mt-2 truncate">{bike.name}</h3>
              <p className="text-xs text-gray-600 mt-1">Year: {bike.makeYear}</p>
              
              {/* "Available at" Dropdown */}
              <div className="mt-3 text-sm font-semibold text-gray-700">Available at</div>
              <select
                className="w-full p-2 mt-1 border-2 bg-gray-50 text-gray-700 hover:bg-gray-100"
              >
                {bike.locations.map((location, index) => (
                  <option key={index} value={location}>
                    {location}
                  </option>
                ))}
              </select>

              <p className="text-sm font-semibold mt-3">Price: ₹{bike.basePrice} / day</p>
              <p className="text-xs text-gray-600 mt-1">Fuel excluded, No distance limit</p>
              <button
                className="mt-3 w-full bg-orange-500 text-white py-1 px-2 hover:bg-orange-600 transition-colors"
                onClick={() => navigate(`/bike-details`, { state: bike })}
              >
                Rent Now
              </button>
            </div>
          ))}
        </div>
      </main>
    </div>
  );
};

export default BikeList;