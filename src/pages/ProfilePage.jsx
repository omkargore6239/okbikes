import React from "react";

const ProfilePage = () => {
  return (
    <div className="flex flex-col min-h-screen bg-gray-100">
      {/* Main Content */}
      <div className="container mx-auto py-8 px-6">
        <div className="grid grid-cols-1 md:grid-cols-4 gap-6 items-start">
          {/* Sidebar */}
          <div className="md:col-span-1 bg-white rounded-lg shadow-md">
            <div className="p-4 text-center border-b border-gray-200">
              <img
                src="https://via.placeholder.com/150"
                alt="Profile"
                className="rounded-full w-24 h-24 mx-auto border-2 border-green-600 mb-4"
              />
              <h2 className="text-xl font-semibold text-gray-800">Omkar Om</h2>
            </div>
            <nav className="text-left divide-y divide-gray-200">
              <div className="py-3 px-4">
                <button className="w-full text-left text-green-600 font-semibold">
                  Profile
                </button>
              </div>
              <div className="py-3 px-4 hover:bg-gray-50">
                <button>Bookings</button>
              </div>
              <div className="py-3 px-4 hover:bg-gray-50">
                <button>Go Coins</button>
              </div>
              <div className="py-3 px-4 hover:bg-gray-50">
                <button>Notifications</button>
              </div>
              <div className="py-3 px-4 hover:bg-gray-50">
                <button>Payment Methods</button>
              </div>
              <div className="py-3 px-4 hover:bg-gray-50">
                <button>Security</button>
              </div>
            </nav>
          </div>

          {/* Profile Details */}
          <div className="md:col-span-3 bg-white rounded-lg shadow-md">
            <div className="p-6">
              <h3 className="text-2xl font-semibold text-gray-700 mb-4 flex items-center">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 24 24"
                  fill="currentColor"
                  className="w-6 h-6 mr-2 text-green-600"
                >
                  <path
                    fillRule="evenodd"
                    d="M18.685 19.097A9.723 9.723 0 0021.75 12c0-5.385-4.365-9.75-9.75-9.75S2.25 6.615 2.25 12a9.723 9.723 0 003.065 7.097A9.716 9.716 0 0012 21.75a9.716 9.716 0 006.685-2.653zm-12.868-1.268A7.009 7.009 0 014.5 12c0-3.868 3.133-7 7-7s7 3.132 7 7-3.132 7-7 7a7.009 7.009 0 01-2.412-5.739z"
                    clipRule="evenodd"
                  />
                </svg>
                Profile
              </h3>
              <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-2 lg:grid-cols-2 gap-4">
                {/* Name */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">Name</h4>
                  <div className="flex items-center justify-between mt-2">
                    <span className="text-lg font-semibold text-gray-700">
                      Omkar Om
                    </span>
                    <button className="flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>

                {/* Email */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">Email</h4>
                  <div className="flex items-center justify-between mt-2">
                    <span className="text-lg text-gray-700">omkar@example.com</span>
                    <button className="flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>

                {/* Mobile */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">Mobile</h4>
                  <div className="flex items-center justify-between mt-2">
                    <span className="text-lg text-gray-700">+91 1234567890</span>
                    <button className="flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>

                {/* Gender */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">Gender</h4>
                  <div className="flex items-center justify-between mt-2">
                    <span className="text-lg text-gray-700">Male</span>
                    <button className="flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>

                {/* Date of Birth */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">Date of Birth</h4>
                  <div className="flex items-center justify-between mt-2">
                    <span className="text-lg text-gray-700">01 Jan 1990</span>
                    <button className="flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>

                {/* Emergency Contact */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">Emergency Contact</h4>
                  <div className="flex items-center justify-between mt-2">
                    <span className="text-lg text-gray-700">+91 9876543210</span>
                    <button className="flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>

                {/* Address */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">Address</h4>
                  <div className="flex flex-col justify-between mt-2">
                    <span className="text-lg text-gray-700">
                      123 Main St, Anytown, State
                    </span>
                    <button className="mt-2 flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>

                {/* License */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">License Number</h4>
                  <div className="flex justify-between mt-2">
                    <span className="text-lg text-gray-700">L123456789</span>
                    <button className="flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>

                {/* Joined Date */}
                <div className="p-4 border rounded bg-gray-50">
                  <h4 className="text-sm text-gray-500">Joined Date</h4>
                  <div className="flex justify-between mt-2">
                    <span className="text-lg text-gray-700">
                      15 Mar 2020
                    </span>
                    <button className="flex items-center text-green-600 font-semibold">
                      Edit <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        className="w-5 h-5 ml-1"
                      >
                        <path
                          fillRule="evenodd"
                          d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32l3.712-3.712 1.414 1.414zm-6.426 9.688l-1.414 1.414-3.712-3.712-4.327 4.327a.75.75 0 000 1.273l4.327 4.327a.75.75 0 101.273-1.273L10.5 16.662z"
                          clipRule="evenodd"
                        />
                      </svg>
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProfilePage;