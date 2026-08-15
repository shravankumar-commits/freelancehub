import Navbar from "./components/Navbar";

import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";

import { Routes, Route } from "react-router-dom";
import {  Navigate } from "react-router-dom";
function ProtectedRoute({ children }) {

    const token = localStorage.getItem("token");

    if (!token) {
        return <Navigate to="/login" />;
    }

    return children;
}
function PublicRoute({children}){
  const token = localStorage.getItem("token");

  if(token){
    return <Navigate to = "/" />;
  }
  return children;
}

function App() {
  return (
    <div>
      <Navbar />

      <Routes>
        <Route 
        path = "/"
        element = {
          <ProtectedRoute>
            <Home/>
          </ProtectedRoute>
        }
        />

        <Route
          path = "/login"
          element = {
            <PublicRoute>
            <Login />
            </PublicRoute>   
          }
        />

        <Route 
         path = "/register"
          element = {
            <PublicRoute>
             <Register />
            </PublicRoute>
        }
        />

      </Routes>
      
    </div>
  );
}

export default App;