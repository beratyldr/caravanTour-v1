import React from 'react'
import { useState, useEffect } from 'react';
import axios from 'axios';
import CarEntity from '../car/CarEntity';
import { Link, useNavigate, useParams } from 'react-router-dom';

export default function CarDetailsPage() {

    const { code } = useParams();
    const navigate = useNavigate();
    const [car, setCar] = useState(
        {
            "code": null,
            "brand": {
                "model": null,
                "code": null,
                "name": null,
                "cars": null
            },
            "constructionYear": null,
            "segment": null,
            "capacity": null,
            "price": null,
            "status": null
        }
    );

    const token = localStorage.getItem('token');


    const getCarbyCode = async () => {
        axios
            .get(`http://localhost:9000/api/v1/getCar/${code}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            })
            .then((response) => {
                setCar(response.data)

            })
            .catch((err) => {
                console.log(err)
            })
    }

    useEffect(() => {
        getCarbyCode()
    }, []);

    return (
        <div className='container'>
            <div className="row">
                <div className="col m-0 p-0">
                    <img src="https://www.victronenergy.com/blog/wp-content/uploads/sites/10/2022/08/IMG_1132_204578188-scaled.jpg" className="img-fluid" alt="..." />
                </div>
                <div className="col border ">
                    <div className="row">
                        <div className="col"><h1>3 GUNLUK 1K</h1></div>
                    </div>
                    <div className="row">
                        <div className="col border-bottom-1"><b>Marka:</b>{car.brand.name}</div>
                    </div>
                    <div className="row">
                        <div className="col border-bottom-1"><b>Kapasite:</b>{car.capacity}</div>
                    </div>
                    <div className="row">
                        <div className="col border-bottom-1"><b>Model:</b>{car.name}</div>
                    </div>
                    <div className="row">
                        <div className="col border-bottom-1"><b>Fiyatı:</b>{car.price}</div>
                    </div>
                    <div className="row">
                        <div className="col border-bottom-1"><b>Uygunluk Durumu:</b>{car.status}</div>
                    </div>
                </div>
            </div>

        </div>
    )
}

