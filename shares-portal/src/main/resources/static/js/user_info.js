let userApp = new Vue({
    el:"#userApp",
    data:{
        user:{},
    },
    created(){
        axios.get("/v1/users/me").then(function (response){
            userApp.user = response.data
            // console.log(response.data)
        }).catch(function (error){
            console.log(error)
        })
    },
    methods:{},

})