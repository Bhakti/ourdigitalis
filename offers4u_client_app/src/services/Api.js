import axios from "axios";
import qs from "qs";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/api/v1/"
});

let appAccessToken = "";
let userAccessToken = "";


export function loginUser(payload) {
  return axiosInstance
    .post(
      "login",
      qs.stringify(payload),
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


export function getCategoryMerchantOffers(categoryName, merchantName){
    var url = 'offers?merchant=${merchantName}';
    if(categoryName!==null) {
        url = url + '&category=${categoryName}'
    }
    return axiosInstance.get('offers?merchant=${merchantName}')
    .then(response => response.data);
}

export function getOffers() {
  return axiosInstance
    .get("offers")
    .then(response => response.data);
}

export function getOffersById(offerId) {
  return axiosInstance
    .get('offers/'+offerId)
    .then(response => response.data);
}

export function getReports(offerId) {
  return axiosInstance
    .get('reports')
    .then(response => response.data);
}
