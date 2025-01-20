import React, { useEffect } from 'react'
import Slider from '../component/general/Slider'
import CarPage from './CarPage'
import { useNavigate } from 'react-router';



export default function HomePage() {

    const navigate = useNavigate();

    useEffect(() => {

    }, [navigate.state]);

    {/*const handleClick = () => {
        console.log("FATIH GUN");
    }*/}

    return (


        <div>
            {/*
            <div className="btn btn-outline-success" onClick={handleClick}>
                DENEME
            </div>
            */}
            <div className="row">
                <div className="col">
                    <div className="card mb-3" >
                        <div className="row g-0">
                            <div className="col-md-4">
                                <img src="https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX3787679.jpg" className="img-fluid rounded-start" style={{ 'height': '150px' }} alt="..." />
                            </div>
                            <div className="col-md-8">
                                <div className="card-body">
                                    <h5 className="card-title">Can Sikintisina birebir.</h5>
                                    <p className="card-text">Ailenize en uygun karavanı bulabilir. İstediğiniz ölçülerde karavan kiralayabilirsiniz. </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col">
                    <CarPage />
                </div>
            </div>

        </div>
    )
}
