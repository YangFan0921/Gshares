let questionApp = new Vue({
    el:"#questionApp",
    data:{
        question:{},
    },
    created(){
        this.loadquestion();
    },
    methods:{
        loadquestion(){
            let qid = location.search.substring(1);
            // console.log(qid);
            if (!qid){
                return
            }
            axios.get("/v1/questions/"+qid).then(function (response){
                questionApp.question = response.data
                addDuration(questionApp.question)
            })
        },
    },
})

let postAnswerApp = new Vue({
    el:"#postAnswerApp",
    data:{
        hasError:false,
        message:"",
    },
    created() {},
    methods: {
        postAnswer(){
            let qid = location.search;
            if (!qid){
                this.message = "必须指定问题id"
                this.hasError = true
                return
            }
            qid = qid.substring(1)
            let content = $("#summernote").val()
            if (!content){
                this.message = "回答内容不能为空"
                this.hasError = true
                return;
            }
            let form = new FormData()
            form.append("questionId",qid)
            form.append("content",content)
            axios.post("/v1/answers",form).then(function (response) {
                // console.log(response.data)
                let answer = response.data
                answersApp.answers.push(answer)
                $("#summernote").summernote("reset")
                postAnswerApp.hasError = false
            }).catch(function (error) {
                console.log(error)
            })
        }
    },
})

let answersApp = new Vue({
    el:"#answersApp",
    data:{
        answers:[],
    },
    created(){
        this.loadAnswers();
    },
    methods:{
        loadAnswers(){
            let qid = location.search;
            if (!qid){
                return
            }
            qid = qid.substring(1)
            // console.log(qid)
            axios.get("/v1/answers/question/"+qid).then(function (response) {
                answersApp.answers = response.data
                // console.log(answersApp.answers)
                let answers = answersApp.answers;
                for (let i = 0; i < answers.length; i++) {
                    addDuration(answers[i])
                }
            }).catch(function (error) {
                console.log(error)
            })
        }
    },
})