let searchApp = new Vue({
    el:"#searchApp",
    data:{
        key:""
    },
    methods:{
        search(){
            //encodeURI防止中文乱码
            location.href="/search.html?key="+encodeURI(this.key)
        }
    }
})