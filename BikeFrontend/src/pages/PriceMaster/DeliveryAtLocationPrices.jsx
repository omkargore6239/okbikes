import React, { useState } from "react";

const DeliveryAtLocationPrices = () => {
  // Initial data for the table
  const initialData = [
    {
      id: 1,
      perKilometer: "5",
      price: "1",
      status: "Additional kilometer-wise charge applies",
    },
    {
      id: 2,
      perKilometer: "15",
      price: "150",
      status: "Best Price",
    },
  ];

  // State for pagination
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5;

  // Pagination calculations
  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentData = initialData.slice(indexOfFirstItem, indexOfLastItem);
  const totalPages = Math.ceil(initialData.length / itemsPerPage);

  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      {/* Header Section */}
      <header className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold text-gray-800">All Price List</h1>
        <button className="px-4 py-2 bg-blue-900 text-white rounded hover:bg-blue-600">
          + Add Price
        </button>
      </header>

      {/* Table Container */}
      <div className="bg-white p-6 shadow-md rounded-lg">
        <table className="w-full text-sm text-left text-gray-500">
          <thead className="text-xs text-gray-700 uppercase bg-gray-200">
            <tr>
              <th className="px-6 py-3">ID</th>
              <th className="px-6 py-3">Per Kilometer</th>
              <th className="px-6 py-3">Price</th>
              <th className="px-6 py-3">Status</th>
              <th className="px-6 py-3">Action</th>
            </tr>
          </thead>
          <tbody>
            {currentData.map((item) => (
              <tr key={item.id} className="bg-white border-b hover:bg-gray-50">
                <th
                  scope="row"
                  className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap"
                >
                  {item.id}
                </th>
                <td className="px-6 py-4">{item.perKilometer}</td>
                <td className="px-6 py-4">{item.price}</td>
                <td className="px-6 py-4">{item.status}</td>
                <td className="px-6 py-4">
                  <button className="px-4 py-2 text-white bg-blue-900 hover:bg-blue-600 rounded">
                    Edit
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* Pagination */}
      <div className="flex justify-between items-center mt-4">
        <p className="text-sm text-gray-500">
          Showing {indexOfFirstItem + 1} to{" "}
          {Math.min(indexOfLastItem, initialData.length)} of{" "}
          {initialData.length} entries
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

export default DeliveryAtLocationPrices;
