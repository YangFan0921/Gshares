let hotQuestionApp = new Vue({
    el:"#hotQuestion",
    data:{
        hotquestions:{},
    },
    created(){
        axios.get("http://localhost:9000/v2/questions/hotquestion").then(function (response){
            hotQuestionApp.hotquestions = response.data;
            // console.log(response.data);
        }).catch(function (error){
            console.log(error)
        })

    },
    methods:{},
})