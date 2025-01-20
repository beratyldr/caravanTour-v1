
import React from "react";
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import { Outlet, RouterProvider, createBrowserRouter } from "react-router-dom";
import Navbar from "./component/general/Navbar";
import HomePage from "./page/HomePage";
import LoginPage from "./page/LoginPage";
import CarPage from "./page/CarPage";
import RegisterPage from "./page/RegisterPage";
import CarDetailsPage from "./page/CarDetailsPage";
import CarCreatePage from "./page/CarCreatePage";
import ToursPage from "./page/ToursPage";

const Layout = () => {
  return (
    <div className="container">
      <div className="row">
        < div className="col">
          <Navbar/>
        </div>
      </div>

      <div className="row">
        < div className="col">
          <Outlet />
        </div>
      </div>
    </div>
  );
}

const router = createBrowserRouter(
  [{
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/home",
        element: <HomePage/>
      },
      {
        path: "/login",
        element: <LoginPage/>
      }
      ,
      {
        path: "/car",
        element: <CarPage/>
      },
      {
        path: "/register",
        element: <RegisterPage/>
      },
      {
        path: "/car/detail/:code",
        element: <CarDetailsPage/>
      },
      {
        path: "/createCar",
        element: <CarCreatePage/>
      },
      {
        path: "/tours",
        element: <ToursPage/>
      }
    ]
  }

  ]
);

function App() {
  return (
    <div className="App">
      <RouterProvider router={router} />
    </div>
  );
}

export default App;
