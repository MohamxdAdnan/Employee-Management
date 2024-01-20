const ApiRequest = async (url, options = null) => {
let response = null;
try{
response = await fetch(url, options);
if (!response.ok) throw new Error("Error in retrieving items");
}
catch (err) {
response = err.message;
}

return response;
};

export default ApiRequest;