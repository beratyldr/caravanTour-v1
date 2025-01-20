import { useState, useEffect } from 'react';
import axios from 'axios';
import CarEntity from '../car/CarEntity';
import { useNavigate } from 'react-router-dom';


export default function CarPage() {
    const navigate = useNavigate();
    const token = localStorage.getItem('token');


    const [cars, setCars] = useState([
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
            "status": null,
        }
    ]);

    const getAllCar = async () => {

        axios
            .get('http://localhost:9000/api/v1/getAllCar', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            })
            .then((response) => {
                setCars(response.data);
            })
            .catch((err) => {
                console.log(err);
            });
    }

    useEffect(() => {
        getAllCar()
    }, []);

    const getCar = code => {
        navigate(`/car/detail/${code}`);
    }


    return (

        <div>
            {token &&
                <div className="row">
                    <a className="btn btn-outline-success" href='/createCar'>ARAÇ EKLE</a>
                </div>
            }
            <div className='row row-cols-1 row-cols-md-3 g-4'>
                {cars && cars.map((car) => (
                    <div className='car' key={car.code} onClick={() => getCar(car.code)}>
                        <CarEntity
                            code={car.code}
                            capacity={car.capacity}
                            status={car.status}
                            price={car.price} />
                    </div>

                ))}
            </div>
        </div>
    )
}
