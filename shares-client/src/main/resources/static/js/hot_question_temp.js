Vue.component("hotquestionapp", {
    props: ["hotquestions"],
    template:
        `
        <div class="container-fluid bg-light mt-5">
        <h4 class="m-2 p-2 font-weight-light"><i class="fa fa-list" aria-hidden="true"></i> 热点问题</h4>
        <div class="list-group list-group-flush" v-for="hotquestion in hotquestions" >
          <a href="question/detail.html" class="list-group-item list-group-item-action" >
            <div class="d-flex w-100 justify-content-between">
              <h6 class="mb-1 text-dark" v-text="hotquestion.title">quals和==的区别是啥？</h6>
            </div>
            <div class="row">
              <div class="col-6">
                <small class="mr-2"><span v-text="hotquestion.countAnswer">1</span>条回答</small>
                <small class="text-warning" style="display: none" v-show="hotquestion.status==0">未回复</small>
                <small class="text-info" style="display: none" v-show="hotquestion.status==1">未解决</small>
                <small class="text-success" v-show="hotquestion.status==2">已解决</small>
              </div>
              <div class="col-6 text-right">
                <small><span v-text="hotquestion.pageViews">21</span>浏览</small>
              </div>
            </div>
          </a>
        </div>
      </div>
    `
})