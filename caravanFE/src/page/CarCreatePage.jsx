import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

export default function CarCreatePage() {

    const navigate = useNavigate();
    const token = localStorage.getItem('token');


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

    const onChange = e => {
        const { name, value } = e.target
        setCar(prev => (
            {
                ...prev,
                [name]: value
            }));
    }

    const onClick = async e => {
        e.preventDefault();
        try {
            const response = await axios.
                post("http://localhost:9000/api/v1/createCar", car, {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    }
                })
                .then((response) => {
                    console.log(response);
                    navigate(`/car/detail/${car.code}`);
                });

        } catch (err) {
            console.log(err)
        }
    }

    return (
        <div>
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <p>Kod</p>
                    <input type="text" className="form-control" onChange={onChange} name='code' />
                </div>
            </div>
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <p>Yapım Yılı</p>
                    <input type="text" className="form-control" onChange={onChange} name='constructionYear' />
                </div>
            </div>
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <p>Segment</p>
                    <input type="text" className="form-control" onChange={onChange} name='segment' />
                </div>
            </div> 
             <div className="mb-3 row">
                <div className="col-sm-10">
                    <p>Fiyat</p>
                    <input type="text" className="form-control" onChange={onChange} name='price' />
                </div>
            </div>
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <p>Uygunluk Durumu</p>
                    <input type="text" className="form-control" onChange={onChange} name='status' />
                </div>
            </div>  
              <div className="mb-3 row">
                <div className="col-sm-10">
                    <p>Yolcu Kapasitesi</p>
                    <input type="text" className="form-control" onChange={onChange} name='capacity' />
                </div>
            </div> 
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <p>Marka</p>
                    <input type="text" className="form-control" onChange={onChange} name='brand.name' />
                </div>
            </div>
            <div className="mb-3 row">
                <div>
                    <button type='submit' onClick={onClick} className='btn btn-primary'>
                        Araç Oluştur
                    </button>
                </div>
            </div>
        </div>
    )
}
