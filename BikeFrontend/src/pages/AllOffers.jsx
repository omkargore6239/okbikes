import React, { useState } from 'react'

const AllOffers = () => {
 // Sample Data
 const initialData = [
  { id: 1, offerName:"New",couponCode:"FIRST20", discount:"Rs.200", totalCoupons:"10", remainingCoupons:"10" },
  { id: 2, offerName:"New",couponCode:"FIRST20", discount:"Rs.200", totalCoupons:"10", remainingCoupons:"10" },
  { id: 3, offerName:"New",couponCode:"FIRST20", discount:"Rs.200", totalCoupons:"10", remainingCoupons:"10" },
  { id: 4, offerName:"New",couponCode:"FIRST20", discount:"Rs.200", totalCoupons:"10", remainingCoupons:"10" },
  { id: 5, offerName:"New",couponCode:"FIRST20", discount:"Rs.200", totalCoupons:"10", remainingCoupons:"10" },
  { id: 6, offerName:"New",couponCode:"FIRST20", discount:"Rs.200", totalCoupons:"10", remainingCoupons:"10" },
  { id: 7, offerName:"New",couponCode:"FIRST20", discount:"Rs.200", totalCoupons:"10", remainingCoupons:"10" },
];

const [statuses, setStatuses] = useState(
  initialData.map((item) => ({ id: item.id, status: "Active" }))
);
const [searchQuery, setSearchQuery] = useState("");
const [currentPage, setCurrentPage] = useState(1);
const itemsPerPage = 5;

// Filtered data based on search query
const filteredData = initialData.filter((item) =>
  item.offerName.toLowerCase().includes(searchQuery.toLowerCase()),
  // item.couponCode.toLowerCase().includes(searchQuery.toLowerCase())
);

// Pagination logic
const indexOfLastItem = currentPage * itemsPerPage;
const indexOfFirstItem = indexOfLastItem - itemsPerPage;
const currentData = filteredData.slice(indexOfFirstItem, indexOfLastItem);
const totalPages = Math.ceil(filteredData.length / itemsPerPage);

// Toggle status function
const toggleStatus = (id) => {
  setStatuses((prevStatuses) =>
    prevStatuses.map((row) =>
      row.id === id
        ? { ...row, status: row.status === "Active" ? "Inactive" : "Active" }
        : row
    )
  );
};

 // Delete function
const handleDelete = (id) => {
setData((prevData) => prevData.filter((item) => item.id !== id));
setStatuses((prevStatuses) => prevStatuses.filter((row) => row.id !== id));
};


return (
  <div className="p-6 bg-gray-100 min-h-screen">
    {/* Header Section */}
    <div className="flex justify-between items-center mb-6">
      <h1 className="text-2xl font-bold text-gray-800">All Offers</h1>
      <button className="px-4 py-2 bg-blue-900 text-white rounded-r hover:bg-blue-600">
        + Add New Offer
      </button>
    </div>


    {/* Table */}
    <div className="bg-white p-6 shadow-md rounded-lg">
    {/* Search Bar */}
    <div className="flex justify-between items-center mb-4">
      <div className="flex items-center">
        <input
          type="text"
          placeholder="Search..."
          className="border border-gray-300 rounded-l px-8 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
      </div>
    </div>
      <div className="relative overflow-x-auto">
        <table className="w-full text-sm text-left text-gray-500">
          <thead className="text-xs text-gray-700 uppercase bg-gray-200">
            <tr>
              <th scope="col" className="px-6 py-3">ID</th>
              <th scope="col" className="px-6 py-3">Offer Name</th>
              <th scope="col" className="px-6 py-3">Coupen Code</th>
              <th scope="col" className="px-6 py-3">Discount</th>
              <th scope="col" className="px-6 py-3">Total Coupons</th>
              <th scope="col" className="px-6 py-3">Remanining Coupons</th>
              <th scope="col" className="px-6 py-3">Status</th>
              <th scope="col" className="px-6 py-3">Action</th>
            </tr>
          </thead>
          <tbody>
            {currentData.map((item) => {
              const rowStatus = statuses.find((status) => status.id === item.id)?.status;
              return (
                <tr key={item.id} className="bg-white border-b hover:bg-gray-50">
                  <th
                    scope="row"
                    className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap"
                  >
                    {item.id}
                  </th>
                  <td className="px-6 py-4">{item.offerName}</td>
                  <td className="px-6 py-4">{item.couponCode}</td>
                  <td className="px-6 py-4">{item.discount}</td>
                  <td className="px-6 py-4">{item.totalCoupons}</td>
                  <td className="px-6 py-4">{item.remainingCoupons}</td>
                  <td className="px-6 py-4">
                    <button
                      className={`px-4 py-2 text-white rounded ${
                        rowStatus === "Active"
                          ? "bg-green-600 hover:bg-green-600"
                          : "bg-red-700 hover:bg-red-600"
                      }`}
                      onClick={() => toggleStatus(item.id)}
                    >
                      {rowStatus}
                    </button>
                  </td>
                  <td className="px-6 py-4">
                    <button className="px-4 py-2 text-white bg-blue-900 hover:bg-blue-600 rounded mr-2">
                      Edit
                    </button>
                    <button
                    className="px-4 py-2 text-white bg-red-600 hover:bg-red-700 rounded"
                    onClick={() => handleDelete(item.id)}
                  >
                    Delete
                  </button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>

    {/* Pagination */}
    <div className="flex justify-between items-center mt-4">
      <p className="text-sm text-gray-500">
        Showing {indexOfFirstItem + 1} to{" "}
        {Math.min(indexOfLastItem, filteredData.length)} of {filteredData.length} entries
      </p>
      <div className="flex space-x-2">
        <button
          className="px-4 py-2 text-sm text-white bg-blue-900 rounded disabled:bg-gray-300 disabled:cursor-not-allowed"
          disabled={currentPage === 1}
          onClick={() => setCurrentPage((prev) => prev - 1)}
        >
          Previous
        </button>
        <button
          className="px-4 py-2 text-sm text-white bg-blue-900 rounded disabled:bg-gray-300 disabled:cursor-not-allowed"
          disabled={currentPage === totalPages}
          onClick={() => setCurrentPage((prev) => prev + 1)}
        >
          Next
        </button>
      </div>
    </div>
  </div>
);
};

export default AllOffers