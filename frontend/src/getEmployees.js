import axios from "axios";

const getUrl="http://localhost:8080/api/employees";

export const getAllEmployees = async ()=> {
    const response = await axios.get(getUrl);
    console.log(response.data);
    return response.data;
}