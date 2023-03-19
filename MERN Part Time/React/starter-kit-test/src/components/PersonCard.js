import React, { useState } from 'react';
const PersonCard = (props) => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirm, setConfirm] = useState("");
    const [hasBeenSubmitted, setHasBeenSubmitted] = useState(false);

    const [firstNameError, setFirstNameError] = useState("");
    const [lastNameError, setLastNameError] = useState("");
    const [emailError, setEmailError] = useState("");
    const [passwordError, setPasswordError] = useState("");
    const [confirmError, setConfirmError] = useState("");

    const handleFirstName = (e) => {
        setFirstName(e.target.value);
        if(e.target.value.length < 1) {
            setFirstNameError("First name is required!");
        }
        else if(e.target.value.length < 2)
            setFirstNameError("First name must be at least 2 characters");
        else {
            setFirstNameError("");
        }
    }
    const handleLastName = (e) => {
        setLastName(e.target.value);
        if(e.target.value.length < 1) {
            setLastNameError("Last name is required!");
        }
        else if(e.target.value.length < 2)
            setLastNameError("Last name must be at least 2 characters");
        else {
            setLastNameError("");
        }
    }
    const handleEmail = (e) => {
        setEmail(e.target.value);
        if(e.target.value.length < 1) {
            setEmailError("Email is required!");
        }
        else if(e.target.value.length < 5)
            setEmailError("Email must be at least 5 characters");
        else {
            setEmailError("");
        }
    }
    const handlePassword = (e) => {
        setPassword(e.target.value);
        if(e.target.value.length < 1) {
            setPasswordError("Password is required!");
        }
        else if(e.target.value.length < 8) {
            setPasswordError("Password must be at least 8 characters.");
        }
        else {
            setPasswordError("");
        }
    }
    const handleConfirm = (e) => {
        setConfirm(e.target.value);
        if (e.target.value.length < 1) {
            setConfirmError("Confirm password is required!")
        }
        else if(e.target.value !== password) {
            setConfirmError("Passwords must match!");
        }
        else {
            setConfirmError("");
        }
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        setHasBeenSubmitted(true);
    }

    return(
        <div>
            <div>
                <form onSubmit={handleSubmit} className="form-group">
                    {   
                        hasBeenSubmitted ? // Ternary operators are a better way to conditionally render an element. This removes the use of an extra function
                        <h3>Thank you for submitting the form!</h3> :
                        <h3>Welcome, please submit the form.</h3>
                    }
                    <div>
                        <label htmlFor="firstName">First Name:</label>
                        <input type="text" onChange={handleFirstName} value={firstName} className="form-control" name="firstName"/>
                        {firstNameError ?
                        <p class="text-danger"> {firstNameError}</p> :
                        ''    
                    }
                    </div>
                    <div>
                        <label htmlFor="lastName">Last Name:</label>
                        <input type="text" onChange={handleLastName} value={lastName} className="form-control" name="lastName"/>
                        {lastNameError ?
                        <p class="text-danger"> {lastNameError}</p> :
                        ''    
                    }
                    </div>
                    <div>
                        <label htmlFor="email">Email:</label>
                        <input type="text" onChange={handleEmail} value={email} className="form-control" name="email"/>
                        {emailError ?
                        <p class="text-danger"> {emailError}</p> :
                        ''    
                    }
                    </div>
                    <div>
                        <label htmlFor="password">Password:</label>
                        <input type="password" onChange={handlePassword} value={password} className="form-control" name="password"/>
                        {passwordError ?
                        <p class="text-danger"> {passwordError}</p> :
                        ''    
                    }
                    </div>
                    <div>
                        <label htmlFor="confirm">Confirm Password:</label>
                        <input type="password" onChange={handleConfirm} value={confirm} className="form-control" name="confirm"/>
                        {confirmError ?
                        <p class="text-danger"> {confirmError}</p> :
                        ''    
                    }
                    </div>
                    {   
                        firstNameError ? 
                        <input type="submit" value="Create User" className="btn btn-primary mt-3 w-100" disabled /> :
                        lastNameError ? 
                        <input type="submit" value="Create User" className="btn btn-primary mt-3 w-100" disabled /> :
                        emailError ? 
                        <input type="submit" value="Create User" className="btn btn-primary mt-3 w-100" disabled /> :
                        passwordError ? 
                        <input type="submit" value="Create User" className="btn btn-primary mt-3 w-100" disabled /> :
                        confirmError ?
                        <input type="submit" value="Create User" className="btn btn-primary mt-3 w-100" disabled /> :
                        
                        <input type="submit" value="Create User" className="btn btn-primary mt-3 w-100"/>
                    }
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

