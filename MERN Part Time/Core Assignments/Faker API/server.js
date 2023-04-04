const { faker } = require('@faker-js/faker');

const express = require("express");
const app = express();
const port = 8000;
    
// req is shorthand for request
// res is shorthand for response
app.get("/api", (req, res) => {
    res.json({ message: "Hello World" });
});

const createUser = () => {
  const newUser = {
    _id: faker.datatype.uuid(),
    firstName: faker.name.firstName(),
    lastName: faker.name.lastName(),
    phoneNumber: faker.phone.phoneNumber(),
    email: faker.internet.email(),
    password: faker.internet.password()
  }
  return newUser;
};

const createCompany = () => {
  const newCompany = {
    _id: faker.datatype.uuid(),
    companyName: faker.company.companyName(),
    streetName: faker.address.streetName(),
    cityName: faker.address.cityName(),
    stateName: faker.address.state(),
    zipCode: faker.address.zipCode(),
    countryName: faker.address.country()
  }
  return newCompany;
}
app.get("/api/users/new", (req, res) => {
  res.json(createUser());
});
app.get("/api/companies/new", (req, res) => {
  res.json(createCompany());
});
app.get("/api/user/company", (req, res) => {
  const userAndCompany = {
    user: createUser(),
    company: createCompany()
  };
  res.json(userAndCompany);
});
// this needs to be below the other code blocks
app.listen( port, () => console.log(`Listening on port: ${port}`) );

