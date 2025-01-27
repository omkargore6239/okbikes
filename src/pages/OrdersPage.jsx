import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../components/Footer";
import { FaMotorcycle, FaCalendarAlt, FaMoneyBillWave, FaMapMarkerAlt, FaClock, FaCheckCircle } from "react-icons/fa";

const OrderPage = () => {
  const navigate = useNavigate();

  // State for dynamic orders and loading
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Fetch orders from API
  useEffect(() => {
    const fetchOrders = async () => {
      const API_URL = "https://localhost:8081/booking/book"; // Replace with your actual API endpoint
      const API_KEY = "https://localhost:8081/booking/book"; // Replace with your actual API key

      try {
        setLoading(true);
        const response = await fetch(API_URL, {
          headers: {
            Authorization: `Bearer ${API_KEY}`,
            "Content-Type": "application/json",
          },
        });

        if (!response.ok) {
          throw new Error("Failed to fetch orders");
        }

        const data = await response.json();
        setOrders(data.orders); // Assuming the response contains an `orders` array
        setLoading(false);
      } catch (err) {
        setError(err.message);
        setLoading(false);
      }
    };

    fetchOrders();
  }, []);

  return (
    <div className="flex flex-col min-h-screen bg-gray-100">
      {/* Main Content */}
      <div className="container mx-auto py-8 px-4">
        <h1 className="text-3xl font-semibold text-center mb-6 text-orange-600">Your Orders</h1>

        {loading && <p className="text-center text-gray-500">Loading orders...</p>}
        {error && <p className="text-center text-red-500">Error: {error}</p>}

        {!loading && !error && orders.length === 0 && (
          <p className="text-center text-gray-500">You have no orders yet.</p>
        )}

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {!loading &&
            !error &&
            orders.map((order, index) => (
              <div key={index} className="bg-white p-6 rounded-lg shadow-md hover:shadow-lg transition">
                <h2 className="text-2xl font-semibold text-gray-800 flex items-center gap-2">
                  <FaMotorcycle className="text-orange-500" /> {order.bike}
                </h2>
                <p className="text-sm text-gray-500 mt-1">
                  Order ID: <span className="font-semibold text-gray-700">{order.orderId}</span>
                </p>

                {/* Order Details */}
                <div className="mt-4 space-y-2">
                  <p className="flex items-center text-gray-700">
                    <FaMoneyBillWave className="text-green-500 mr-2" /> <strong>Price:</strong> ₹{order.totalPrice}
                  </p>
                  <p className="flex items-center text-gray-700">
                    <FaCalendarAlt className="text-blue-500 mr-2" /> <strong>Rental Days:</strong> {order.rentalDays}
                  </p>
                  <p className="flex items-center text-gray-700">
                    <FaClock className="text-yellow-500 mr-2" /> <strong>Order Date:</strong>{" "}
                    {new Date(order.orderDate).toLocaleDateString()}
                  </p>
                  <p className="flex items-center text-gray-700">
                    <FaCheckCircle
                      className={`mr-2 ${order.status === "Completed" ? "text-green-500" : "text-red-500"}`}
                    />
                    <strong>Status:</strong> {order.status}
                  </p>
                </div>

                {/* Pickup & Delivery Details */}
                <div className="mt-4">
                  <h3 className="text-xl font-semibold text-gray-800">Delivery Details</h3>
                  <p className="flex items-center text-gray-700">
                    <FaMapMarkerAlt className="text-red-500 mr-2" /> <strong>Pickup:</strong> {order.pickupLocation}
                  </p>
                  <p className="flex items-center text-gray-700">
                    <FaMapMarkerAlt className="text-green-500 mr-2" /> <strong>Drop-off:</strong> {order.deliveryLocation}
                  </p>
                </div>

                {/* Rent Again Button */}
                <button
                  className="mt-4 w-full bg-orange-500 text-white py-2 rounded hover:bg-orange-600 transition"
                  onClick={() => navigate("/")}
                >
                  Rent Again
                </button>
              </div>
            ))}
        </div>
      </div>
    </div>
  );
};

export default OrderPage;
