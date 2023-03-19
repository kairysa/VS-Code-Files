import React, { useState } from 'react';
const PersonCard = (props) => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirm, setConfirm] = useState("");

    const createUser = (e) => {

        const newUser = {
            firstName: firstName,
            lastName: lastName,
            email: email,
            password: password,
            confirm: confirm
        }
        setFirstName("");
        setLastName("");
        setEmail("");
        setPassword("");
        setConfirm("");
    }

    return(
        <div>
            <div>
                <form onSubmit={createUser} className="form-group">
                    <div>
                        <label htmlFor="firstName">First Name:</label>
                        <input type="text" onChange={ (e) => setFirstName(e.target.value)} value={firstName} className="form-control" name="firstName"/>
                    </div>
                    <div>
                        <label htmlFor="lastName">Last Name:</label>
                        <input type="text" onChange={ (e) => setLastName(e.target.value)} value={lastName} className="form-control" name="lastName"/>
                    </div>
                    <div>
                        <label htmlFor="email">Email:</label>
                        <input type="text" onChange={ (e) => setEmail(e.target.value)} value={email} className="form-control" name="email"/>
                    </div>
                    <div>
                        <label htmlFor="password">Password:</label>
                        <input type="password" onChange={ (e) => setPassword(e.target.value)} value={password} className="form-control" name="password"/>
                    </div>
                    <div>
                        <label htmlFor="confirm">Confirm Password:</label>
                        <input type="password" onChange={ (e) => setConfirm(e.target.value)} value={confirm} className="form-control" name="confirm"/>
                    </div>
                    <input type="submit" value="Create User" className="btn btn-primary mt-3 w-100"/>
                </form>
            </div>
            <div>
                <h2>Your Form Data</h2>
                <p>First Name: {firstName}</p>
                <p>Last Name: {lastName}</p>
                <p>Email: {email}</p>
                <p>Password: {password}</p>
                <p>Confirm Password: {confirm}</p>
            </div>
        </div>
    )
}
export default PersonCard;

