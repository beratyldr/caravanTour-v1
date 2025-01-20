
import axios from 'axios';
import React from 'react';
import { useNavigate } from 'react-router';

export default function Navbar() {
    const token = localStorage.getItem('token');
    const navigate = useNavigate();

    const logout = async () => {

        axios
            .get('http://localhost:9000/api/v1/auth/signout')
            .then((response) => {
                console.log(response.data);
                localStorage.removeItem('token');
                navigate('/home', { state: { redirect: true } });
            })
            .catch((err) => {
                console.log(err);
            });
    }

    return (
        <>
            <nav className="navbar navbar-expand-lg bg-body-tertiary mb-4">
                <div className="container-fluid">
                    <a className="navbar-brand" href="#">Caravan</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/home">Home</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/tours">Turlar</a>
                            </li>
                            {!token && <>
                                <li className="nav-item">
                                    <a className="nav-link active" aria-current="page" href="/login">Login</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link active" aria-current="page" href="/register">Register</a>
                                </li>
                            </>
                            }
                            {token &&
                                <li className="nav-item">
                                    <button className="nav-link active" aria-current="page" onClick={logout}>Logout</button>
                                </li>
                            }
                        </ul>
                    </div>
                    <form className="d-flex" role="search">
                        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                        <button className="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </>
    )
}
