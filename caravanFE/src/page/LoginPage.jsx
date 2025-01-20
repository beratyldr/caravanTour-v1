import React, { useState } from 'react'
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';


export default function LoginPage() {

    const [user, setUser] = useState({ email: null, password: null })
    const navigate = useNavigate();

    const onClick = async e => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:9000/api/v1/auth/login", user);
            localStorage.setItem('token', response.data.token);
            navigate('/home', { state: { redirect: true } });
        } catch (err) {
            console.log(err)
        }

    }

    const onChange = e => {
        const { name, value } = e.target
        setUser(prev => (
            {
                ...prev,
                [name]: value
            }));

    }

    return (
        <div>
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <input type="text" className="form-control" onChange={onChange} name='email' />
                </div>
            </div>
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <input type="password" className="form-control" onChange={onChange} name='password' />
                </div>
            </div>
            <div>
                <button type='submit' onClick={onClick} className='btn btn-primary'>
                    Login
                </button>
            </div>
        </div>
    )
}
