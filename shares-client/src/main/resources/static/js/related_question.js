let relatedQuestionApp = new Vue({
    el:"#relatedQuestionApp",
    data:{
        relatedquestions:{},
    },
    created(){
        axios.get("http://localhost:9000/v2/questions/relatedquestion",{params:{"accessToken":token}}).then(function (response) {
            // console.log(response.data)
            relatedQuestionApp.relatedquestions = response.data
        }).catch(function (error) {
            console.log(error)
        })
    },
    methods:{},
})