import {
   // get,
    post
} from './api'

export const serverPage = data => post('/server/serverPage', data);
export const addServer = data => post('/server/addServer',data);
export const deleteServer = data => post('/server/deleteServer',data);


export const devProPage = data => post('/devPro/devProPage',data);
export const addDevPro = data => post('/devPro/addDevPro',data);
export const deleteDevPro = data => post('/devPro/deleteDevPro',data);
export const devProInfo = data => post('/devPro/devProInfo',data);

export const proCodeRepoPage = data => post('/proCR/proCRPage',data);
export const addProCodeRepo = data => post('/proCR/addProCR',data);
export const deleteProCodeRepo = data => post('/proCR/deleteProCR',data);

export const proSoftwarePage = data => post('/proSoftware/proSoftwarePage',data);
export const addProSoftware = data => post('/proSoftware/addProSoftware',data);
export const deleteProSoftware = data => post('/proSoftware/deleteProSoftware',data); 

export const proImagePage = data => post('/proImage/proImagePage',data);
export const addProImage = data => post('/proImage/addProImage',data);
export const deleteProImage = data => post('/proImage/deleteProImage',data);

export const proReleasePage = data => post('/proRelease/proReleasePage',data);
export const addProRelease = data => post('/proRelease/addProRelease',data);
export const deleteProRelease = data => post('/proRelease/deleteProRelease',data);






