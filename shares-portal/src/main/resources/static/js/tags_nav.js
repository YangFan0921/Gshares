let tagsApp = new Vue({
    el:'#tagsApp',
    data:{
        tags:[]
    },
    methods:{
        loadTags:function () {
            // console.log('执行了 loadTags');
            axios({
                url:'/v1/tags',
                method:'GET'
            }).then(function(response){
                if(response.status==OK){
                    tagsApp.tags=response.data;
                }
            })
        }
    },
    created:function () {
        this.loadTags();
    }
});