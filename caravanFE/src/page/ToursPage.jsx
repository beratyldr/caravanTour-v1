import axios from 'axios';
import React, { useEffect } from 'react'

export default function ToursPage() {

    const token = localStorage.getItem('token');
    
    const getAllTour = async () => {

        axios
            .get('http://localhost:9000/api/v1/getAllTour')
            .then((response) => {
                console.log(response.data);
            })
            .catch((err) => {
                console.log(err);
            });
    }

    useEffect(() => {
        getAllTour()
    }, []);

    return (
    <div>ToursPage</div>
  )
}
