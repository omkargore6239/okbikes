import axios from "axios";
import React, { useEffect, useState } from "react";
import { FaEdit } from "react-icons/fa";
import apiClient from "../api/apiConfig";

function convertImageToBase64(file) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.onload = () => {
      resolve(reader.result);
    };
    reader.onerror = (error) => {
      reject(error);
    };
    reader.readAsDataURL(file);
  });
}

const StoreMaster = () => {
  const [data, setData] = useState([]);
  const [statuses, setStatuses] = useState([]);
  const [searchQuery, setSearchQuery] = useState("");
  const [currentPage, setCurrentPage] = useState(1);
  const [formVisible, setFormVisible] = useState(false); // Form state
  const [editingId, setEditingId] = useState(null);
  const [confirmDeleteId, setConfirmDeleteId] = useState(null);
  const [formData, setFormData] = useState({
    storeName: "",
    storeContactNumber: "",
    address: "",
    storeGoogleMapUrl: "",
    city:"",
    storeImage: " ",
  });
  const [loading, setLoading] = useState(true);
  const [itemsPerPage] = useState(5);

  //Fetch store data
  useEffect(() => {
    const fetchStores = async () => {
      setLoading(true);
      try {
        // const response = await axios.get(
        // "http://localhost:8080/api/stores/list"
        // );
        const response = await apiClient.get("/stores/list");
        setData(response.data);
        setStatuses(
          response.data.map((item) => ({ id: item.id, status: "Active" }))
        );
      } catch (error) {
        console.error("Error fetchig store data:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchStores();
  }, []);

  //Add Store
  const handledAddStore = (e) => {
    e.preventDefault();
    console.log(formData);
    axios;
    apiClient
      .post("/stores/save", formData)
      .then((response) => {
        setData([...data, response.data]);
        resetForm();
      })
      .catch((error) => console.error("Error adding store data", error));
  };

  //Save Edit
  const handleSaveEdit = (e) => {
    e.preventDefault();
    axios;
    apiClient
      .put(`/stores/${editingId}`, formData)
      .then((response) => {
        setData(
          data.map((store) => (store.id === editingId ? response.data : store))
        );
        resetForm();
      })
      .catch((error) => console.error("Error Saving Data:", error));
  };

  //Edit store
  const handleEditStore = (store) => {
    setEditingId(store.id);
    setFormData({
      storeName: store.storeName,
      storeContactNumber: store.storeContactNumber,
      address: store.address,
      storeGoogleMapUrl: store.storeGoogleMapUrl,
      city:store.city,
      storeImage: store.storeImage,

    });
    setFormVisible(true);
  };

  //Delete Store
  const handleDeleteStore = (id) => {
    axios;
    apiClient
      .delete(`/stores/${id}`)
      .then(() => setData(data.filter((store) => store.id !== id)))
      .catch((error) => console.error("Error deleting data:", error))
      .finally(() => setConfirmDeleteId(null));
  };

  //Reset Form
  const resetForm = () => {
    setEditingId(null);
    setFormData({
      storeName: "",
      storeContactNumber: "",
      address: "",
      storeGoogleMapUrl: "",
      city:" ",
      storeImage: "",
    });
    setFormVisible(false);
  };

  // Filtered data based on search query
  const filteredData = data.filter(
    (item) => item.storeName.toLowerCase().includes(searchQuery.toLowerCase()) // Fix here
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

  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      {/* Header Section */}
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold text-gray-800">All Store List</h1>
        {!formVisible && (
          <button
            onClick={() => setFormVisible(true)}
            className="px-4 py-2 bg-blue-900 text-white rounded-r hover:bg-blue-600"
          >
            + Add Store
          </button>
        )}
      </div>

      {/* formVisible */}
      {formVisible ? (
        // <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
        <div className="bg-white p-6 rounded-lg shadow-lg">
          <h2 className="text-xl font-bold mb-4">
            {editingId ? "Edit Store" : "Add New Store"}
          </h2>
          <form onSubmit={editingId ? handleSaveEdit : handledAddStore}>
            <div className="grid grid-cols-3 gap-4">
              <div className="col-span-2 sm:col-span-1">
                <label className="font-medium">Store Name</label>
                <input
                  type="text"
                  name="storeName"
                  placeholder="Enter Store Name"
                  className="border p-2 rounded w-full"
                  value={formData.storeName}
                  onChange={(e) =>
                    setFormData({ ...formData, storeName: e.target.value })
                  }
                  required
                />
              </div>
              <div className="mb-4">
                <label className="block mb-2 font-medium">Contact Number</label>
                <input
                  type="mobile number"
                  name="storeContactNumber"
                  className="w-full border border-gray-300 p-2 rounded"
                  value={formData.storeContactNumber}
                  onChange={(e) =>
                    setFormData({
                      ...formData,
                      storeContactNumber: e.target.value,
                    })
                  }
                  required
                />
              </div>
              <div className="mb-4">
                <label className="block mb-2 font-medium">Address</label>
                <input
                  type="text"
                  name="address"
                  className="w-full border border-gray-300 p-2 rounded"
                  value={formData.address}
                  onChange={(e) =>
                    setFormData({ ...formData, address: e.target.value })
                  }
                  required
                />
              </div>
              <div className="mb-4">
                <label className="block mb-2 font-medium">Google Map URL</label>
                <input
                  type="text"
                  name="storeGoogleMapUrl"
                  className="w-full border border-gray-300 p-2 rounded"
                  value={formData.storeGoogleMapUrl}
                  onChange={(e) =>
                    setFormData({
                      ...formData,
                      storeGoogleMapUrl: e.target.value,
                    })
                  }
                />
              </div>
              <div className="mb-4">
                <label className="block mb-2 font-medium">City</label>
                <input
                  type="text"
                  name="city"
                  className="w-full border border-gray-300 p-2 rounded"
                  value={formData.city}
                  onChange={(e) =>
                    setFormData({
                      ...formData,
                      city: e.target.value,
                    })
                  }
                />
              </div>
              <div className="mb-4">
                <label className="block mb-2 font-medium">Store Photos</label>
                <input
                  type="file"
                  name="storeImage"
                  className="w-full border border-gray-300 p-2 rounded"
                  onChange={async (e) => {
                    const file = e.target.files[0];
                    if (file) {
                      try {
                        const base64String = await convertImageToBase64(file);
                        console.log("Base64:", base64String);
                        setFormData({
                          ...formData,
                          storeImage: base64String,
                        });
                      } catch (error) {
                        console.error("Error converting image:", error);
                      }
                    }
                  }}
                />
                {formData.storeImage && (
                  <div className="mt-2">
                    <div className="w-[90px] h-[90px] border border-gray-300 rounded flex items-center justify-center overflow-hidden">
                      <img
                        src={formData.storeImage}
                        alt="Preview"
                        className="w-full h-full object-cover"
                      />
                    </div>
                  </div>
                )}
              </div>
            </div>

            <div className="flex justify-end">
              <button
                type="submit"
                className="px-4 py-2 mr-2 text-white bg-blue-900 rounded hover:bg-blue-600"
              >
                {editingId ? "Save" : "Add"}
              </button>
              <button
                type="button"
                className="ml-4 px-4 py-2 bg-gray-300 rounded hover:bg-gray-400"
                onClick={resetForm}
              >
                Cancel
              </button>
            </div>
          </form>
        </div>
      ) : (
        // </div>

        <div className="bg-white p-6 shadow-md rounded-lg">
          {/* Search Bar */}
          <div className="flex justify-between items-center mb-4">
            <div className="flex items-center">
              <input
                type="text"
                placeholder="Search by Store Name..."
                className="border border-gray-300 rounded-l px-8 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
              />
            </div>
          </div>

          {/* Table */}
          <div className="relative overflow-x-auto">
            <table className="w-full text-sm text-left text-gray-500">
              <thead className="text-xs text-gray-700 uppercase bg-gray-200">
                <tr>
                  <th scope="col" className="px-6 py-3">
                    ID
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Store Image
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Store Name
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Contact Number
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Address
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Status
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Action
                  </th>
                </tr>
              </thead>
              <tbody>
                {loading ? (
                  <tr>
                    <td colSpan="6" className="text-center py-4">
                      Loading...{" "}
                    </td>
                  </tr>
                ) : currentData.length === 0 ? (
                  <tr>
                    <td colSpan="6" className="text-center py-4">
                      No data found
                    </td>
                  </tr>
                ) : (
                  currentData.map((store) => (
                    <tr
                      key={store.id}
                      className="bg-white border-b hover:bg-gray-50"
                    >
                      <td className="px-6 py-4">{store.id}</td>
                      <td className="px-6 py-4">
                        {store.storeImage ? (
                          <img
                            src={store.storeImage}
                            alt="Uploaded Base64"
                            style={{
                              width: "80px",
                              height: "80px",
                              objectFit: "cover",
                            }}
                          />
                        ) : (
                          "-"
                        )}
                      </td>

                      <td className="px-6 py-4">{store.storeName}</td>
                      <td className="px-6 py-4">{store.storeContactNumber}</td>
                      <td className="px-6 py-4">
                        <a
                          href={store.storeGoogleMapUrl}
                          target="_blank"
                          rel="noopener noreferrer"
                          className="text-blue-500 hover:underline"
                        >
                          {store.address}
                        </a>
                      </td>

                      <td className="px-6 py-4">
                        <button
                          className={`px-2 py-1 rounded ${
                            statuses.find((row) => row.id === store.id)
                              ?.status === "Active"
                              ? "bg-green-600 hover:bg-green-600 text-white"
                              : "bg-red-700 hover:bg-red-600 text-white"
                          }`}
                          onClick={() => toggleStatus(store.id)}
                        >
                          {statuses.find((row) => row.id === store.id)
                            ?.status ?? "Active"}
                        </button>
                      </td>

                      <td className="px-6 py-4">
                        <button
                          className="px-4 py-2 flex items-center text-white bg-blue-800 hover:bg-blue-600 rounded mr-2"
                          onClick={() => handleEditStore(store)}
                        >
                          <FaEdit className="mr-2" />
                          Edit
                        </button>
                        <button
                          className="px-4 py-2 text-white bg-red-800 hover:bg-red-600 rounded"
                          onClick={() => setConfirmDeleteId(store.id)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  ))
                )}
              </tbody>
            </table>
          </div>

          {/* Delete Confirmation  */}
          {confirmDeleteId && (
            <div className="fixed inset-0 flex items-center justify-center bg-gray-900 bg-opacity-50 z-50">
              <div className="bg-white p-6 rounded shadow-lg">
                <h3 className="text-xl font-bold mb-4">Confirm Delete</h3>
                <p className="mb-4">
                  Are you sure you want to delete this Store?
                </p>
                <div className="flex justify-end space-x-4">
                  <button
                    className="bg-red-500 text-white px-4 py-2 rounded shadow-md hover:bg-red-700"
                    onClick={() => handleDeleteStore(confirmDeleteId)}
                  >
                    Yes, Delete
                  </button>
                  <button
                    className="bg-gray-500 text-white px-4 py-2 rounded shadow-md hover:bg-gray-700"
                    onClick={() => setConfirmDeleteId(null)}
                  >
                    Cancel
                  </button>
                </div>
              </div>
            </div>
          )}

          {/* Pagination */}
          <div className="flex justify-between items-center mt-6">
            <p className="text-sm text-gray-500">
              Showing {indexOfFirstItem + 1}to{" "}
              {Math.min(indexOfLastItem, filteredData.length)} of{" "}
              {filteredData.length} entries
            </p>
            <div className="flex space-x-2">
              <button
                className="px-4 py-2 text-sm text-white bg-blue-900 rounded disabled:bg-gray-300 disabled:cursor-not-allowed"
                disabled={currentPage === 1}
                onClick={() => setCurrentPage((prev) => prev - 1)}
              >
                Previous
              </button>
              {[...Array(totalPages)].map((_, index) => (
                <button
                  key={index}
                  className={`px-4 py-2 rounded ${
                    currentPage === index + 1
                      ? "bg-blue-900 text-white"
                      : "bg-gray-200 text-gray-700 hover:bg-gray-300"
                  }`}
                  onClick={() => setCurrentPage(index + 1)}
                >
                  {index + 1}
                </button>
              ))}
              <button
                disabled={currentPage === totalPages}
                onClick={() => setCurrentPage((prev) => prev + 1)}
                className={`px-4 py-2 rounded ${
                  currentPage === totalPages
                    ? "bg-gray-300 text-gray-500"
                    : "bg-blue-900 text-white hover:bg-blue-600"
                }`}
              >
                Next
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default StoreMaster;
