let relatedQuestionApp = new Vue({
    el:"#relatedQuestionApp",
    data:{
        relatedquestions:{},
    },
    created(){
        axios.get("/v1/questions/relatedquestion").then(function (response) {
            // console.log(response.data)
            relatedQuestionApp.relatedquestions = response.data
        }).catch(function (error) {
            console.log(error)
        })
    },
    methods:{},
})