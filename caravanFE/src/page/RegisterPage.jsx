import React, { useState } from 'react'
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';




export default function RegisterPage() {


    const UserRoleEnum = {
        ROLE_ADMIN: 'ROLE_ADMIN',
        ROLE_USER: 'ROLE_USER'
    };


    const [user, setUser] = useState({
        firstName: null,
        email: null,
        password: null,
        lastName: null,
        role: null
    })
    const navigate = useNavigate();

    const onClick = async e => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:9000/api/v1/auth/signup", user);
            localStorage.setItem('token', response.data);
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
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <input type="text" className="form-control" onChange={onChange} name='firstName' />
                </div>
            </div>
            <div className="mb-3 row">
                <div className="col-sm-10">
                    <input type="text" className="form-control" onChange={onChange} name='lastName' />
                </div>
            </div>
            <select onChange={onChange} name='role' className='select mb-2'>
                <option value={UserRoleEnum.ROLE_ADMIN} name='role'>Admin</option>
                <option value={UserRoleEnum.ROLE_USER} name='role'>Kullanıcı</option>
            </select>
            <div>
                <button type='submit' onClick={onClick} className='btn btn-primary'>
                    Kayıt
                </button>
            </div>
        </div>
    )
}


