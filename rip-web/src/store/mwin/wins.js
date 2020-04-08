export default {
    state:{
        wins:[
            // {name:"我的云系统",icon:"fa-mixcloud",isSelect:false,left:0,top:0,oToMany:false,iffocus:false}
          ],
        nleft:300,
        ntop:200
    },
    mutations:{
        addWin(state,menu){
            if(menu.oToMany){
                state.wins.forEach(owin => {
                    owin.iffocus=false;
                })
                let winn = {};
                winn = Object.assign(winn, menu);
                winn.left=state.nleft+35*state.wins.length;
                winn.top=state.ntop+20*state.wins.length;
                winn.width=600;
                winn.height=400;
                winn.iffocus=true;
                winn.winstat={};winn.winstat.size="normal";
                state.wins.push(winn);
            }else{
                let ifnew = true;
                state.wins.forEach(owin => {
                    if(owin.key === menu.key){
                        ifnew =false;
                        owin.iffocus=true;
                        if(owin.winstat.size=="min"){
                            owin.winstat.size = owin.winstat.oldSize;
                        }
                    }else{
                        owin.iffocus=false;
                    }
                });
                if(ifnew){
                    let winn = {};
                    winn = Object.assign(winn, menu);
                     if(!winn.winleft||winn.winleft===0){
                        winn.left=state.nleft+35*state.wins.length;
                        winn.top=state.ntop+20*state.wins.length;                        
                     } else{
                        winn.left=winn.winleft;
                        winn.top=winn.wintop;
                     }                
                    if(!menu.width){
                        winn.width=600;
                        winn.height=400;
                    }
                    if(menu.onlyExitBtn){
                        winn.onlyExitBtn=true;
                    }
                    if(menu.disresize){
                        winn.disresize=true;
                    }

                    winn.iffocus=true;
                    winn.winstat={};
                    winn.winstat.size="normal";
                    state.wins.push(winn);
                }
            }
        },
        focusWin(state,win){  
            state.wins.forEach(owin => {
                owin.iffocus=false;
                if(owin.key === win.key){
                    owin.iffocus=true;
                }
            })
            
        },
        delWin(state,win){
            console.log("del");
            for (let i = 0; i < state.wins.length; i++) {
                let owin = state.wins[i];
                if (owin.key === win.key) {
                    state.wins.splice(i, 1); // 将使后面的元素依次前移，数组长度减1 
                   break;
                }
            }    
         //   state.wins.push(win);
            //state.wins.pop();
        }
    },
    actions:{

    },
    getters:{

    }
}