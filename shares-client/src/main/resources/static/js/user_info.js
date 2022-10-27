let userApp = new Vue({
    el:"#userApp",
    data:{
        user:{},
    },

    created(){
        axios.get("http://localhost:9000/v1/users/me",{params:{"accessToken":token}}).then(function (response){
            userApp.user = response.data
            // console.log(response.data)
        }).catch(function (error){
            console.log(error)
        })
    },
    methods:{},

})