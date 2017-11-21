import axios from "axios";
import qs from "qs";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/api/v1/"
});

let appAccessToken = "";
let userAccessToken = "";


export function loginUser(username, password) {
  return axiosInstance
    .post(
      "login",
      qs.stringify({
        username: username,
        password: password
      }),
      {
        headers: {
          "content-type": "application/x-www-form-urlencoded"
        }
      }
    )
    .then(response => {
      userAccessToken = response.data.access_token;
      return userAccessToken;
    });
}

export function registerUser(customer, token) {
  return axiosInstance
    .post(
      "register",
      {
        customer:customer
      },
      {
        headers: {
          "content-type": "application/json",
        }
      }
    )
    .then(response => response.data);
}

///////////////////////////////////////////////////////////////////////
//all
export function getCategories(){
    return axiosInstance.get('categories')
    .then(response => response.data._embedded.categories);
}

//all
export function getMerchants(){
    return axiosInstance.get('merchants')
    .then(response => response.data._embedded.merchants);
}

//all
export function getCustomers(){
    return axiosInstance.get('customers')
    .then(response => response.data._embedded.customers);
}

//one
export function getCustomer(customerId){
    return axiosInstance.get('customers/'+customerId)
    .then(response => response.data)
}

//NA -- check
export function getClientPreferences(customerId){
    return axiosInstance.get('customers/'+customerId+'preferences')
    .then(response => response.data);
}

//NA --check
export function getClientOffers(customerId){
    return axiosInstance.get('customers/'+customerId+'reommendedOffers')
    .then(response => response.data);
}

//NA --check
export function getClientNotifications(customerId){
    return axiosInstance.get('customers/'+customerId+'notifications')
    .then(response => response.data);
}


export function getMerchantOffers(merchantName){
    return axiosInstance.get('offers?merchant=${merchantName}')
    .then(response => response.data);
}

export function getOffers() {
  return axiosInstance
    .get("offers")
    .then(response => response.data);
}

export function getOffers(offerId) {
  return axiosInstance
    .get('offers/'+userId)
    .then(response => response.data);
}
