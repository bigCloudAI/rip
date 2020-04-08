
const WebSQL={
    // install 是默认的方法。当外界在 use 这个组件的时候，就会调用本身的 install 方法，同时传一个 Vue 这个类的参数。
    install:function(Vue){
        if(window.openDatabase){
            let db = openDatabase("ripdb",'1.0','rip客户端数据库',2 * 1024 * 1024);
            Vue.prototype.$db = db;
            if(!db){
                console.log("数据库创建失败");
            }
        }
    }
}


 export default WebSQL;