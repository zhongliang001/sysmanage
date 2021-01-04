import axios from "axios";
import zlService from "./zlservice";

let request = axios.create({
    responseType: 'json',
    timeout: 3000,
    timeoutErrorMessage: '请求超时',
    token: ''
});
request.defaults.headers = {'Content-Type':'application/x-www-form-urlencoded'}
request.interceptors.request.use(config => {
        return new Promise(resolve => {
            // 模拟等待refresh_token
            setTimeout(function (config_param) {
                resolve(config_param);
            }, 2000, config)
        });
    });
let zlaxios = {
    request: function (url) {
        url =  zlService.baseUrl + url
        return request.post(url)
    }
}

export default zlaxios
