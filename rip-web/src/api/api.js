
import axios from 'axios'
import store from '@/store/index'
import qs from 'qs'

const service = axios.create({
    baseURL: store.state.env=="prod"?store.state.prodUrl:store.state.baseUrl,
})
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'; //配置请求头
// axios.defaults.headers.common['X-Access-Token'] = getToken();

const err = (error) => {
    if (error.response) {
        //let data = error.response.data
        const token = localStorage.getItem("ACCESS_TOKEN")
        console.log("------异常响应------", token)
        console.log("------异常响应------", error.response.status)
        switch (error.response.status) {
            case 403:
                break
            case 500:
                break
            case 404:
                break
            case 504:
                break
            case 401:
                break
            default:
                break
        }
    } else {
        //let message = '请求失败！请检查网络';
    }
    return Promise.reject(error)
};

// response interceptor
service.interceptors.response.use((response) => {
    return response.data
    /* if (response.data.code == '2000' || response.data.code == '3000') {
         return response.data
     } else {
         notification.error({message: '系统提示', description: '111', duration: 4})
         return {desc: '请求失败'}
     }*/
}, err)

/**
 * 封装get方法
 * @param url
 * @param params
 * @returns {Promise}
 */
export function get(url, params = {}) {
    return new Promise((resolve, reject) => {
        service.get(url, {
            params: params
        })
            .then(response => {
                resolve(response);
            }, err => {
                reject(err);
            })
            .catch((error) => {
                reject(error)
            })
    })
}

/**
 * 封装post请求
 * @param url
 * @param data
 * @returns {Promise}
 */

export function post(url, data = {}) {
    return new Promise((resolve, reject) => {
        service.post(url, qs.stringify(data))
            .then(response => {
                resolve(response);
            }, err => {
                reject(err);
            })
            .catch((error) => {
                reject(error)
            })
    })
}

/**
 * 封装post文件方法
 * @param url
 * @param data
 * @param onUploadProgress
 * @returns {Promise<any>}
 */
export function postFile(url, data = {}, onUploadProgress) {
    let boundary = Date.parse(new Date()) + "" + Math.floor(Math.random() * 100);
    let config = {
        //添加请求头
        headers: {
            "Content-Type": "multipart/form-data;boundary=" + boundary
        },
        //添加上传进度监听事件
        onUploadProgress: onUploadProgress
    };
    return new Promise((resolve) => {
        service.post(url, data, config)
            .then(res => {
                resolve(res);
            })
    })
}

/**
 * get同步请求封装
 * @param {*} url
 * @param {*} data
 */
export async function getAwait(url, data) {
    try {
        let res = await service.get(url, {
            params: data
        })
        return new Promise((resolve) => {
            resolve(res)
        })
    } catch (err) {
        console.log(err)
    }
}

/**
 * post 同步请求封装
 * @param {*} url
 * @param {*} data
 */
export async function postAwait(url, data) {
    try {
        let res = await service.post(url, qs.stringify(data))
        return new Promise((resolve) => {
            resolve(res)
        })
    } catch (err) {
        console.log(err)
    }
}