<script setup lang="ts">
import {onMounted, ref} from "vue";
import type {ArticleListReq, IArticle} from "@/api/interface/article/article";
import type {Page} from "@/api/interface/IResult";
import {getArticleList, getDefaultPageIArticle} from "@/api/articleApi";


const articlePageInfo = ref({
  current: 1,
  total: 0,
  records: [] as IArticle[]
} as Page<IArticle>)

const articleListReq = ref(
    {
      pageNumber: 1,
      pageSize: 2
    } as ArticleListReq)

function articleList() {
  getArticleList(articleListReq.value).then(result => {
    const pageDataRes: Page<IArticle> = result.data
    console.log("pageDataRes: " + JSON.stringify(pageDataRes))
    articlePageInfo.value = pageDataRes;
  }).catch(error => {
    return getDefaultPageIArticle("获取页面文章出错了")
  })
}

const url =
    'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg'
const srcList = [
  'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
  'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
  'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
  'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg',
  'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
  'https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg',
  'https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg',
]

function getSpanLength(index: number, isLeft: boolean): number {
  console.log("index = " + index + "  isLeft: "+isLeft+ " is " + (index % 8 == 0 && isLeft))
  if (index % 2 == 0 && !isLeft) {
    return 16
  }
  if (index % 2 != 0 && isLeft) {
    return 8
  }

  return 16

}

// 页面挂载时，渲染
onMounted(() => {
  articleList()
})
</script>

<template>
  <div class="flex flex-wrap gap-4 zj-article-container">
    <el-row v-for="(post, index) in articlePageInfo.records"
            :key="post.id"
            type="flex"
            justify="space-between"
            align="middle"
            style="margin-bottom: 20px;">
      <el-col :span="getSpanLength(index + 1, true)">
        <el-card class="post-card" style="width: 100%; padding: 20px;">
          <img slot="header" :src="url" class="post-image" alt="博客图片">
        </el-card>
      </el-col>
      <el-col :span="getSpanLength(index + 1, false)">
        <el-card class="post-info-card" style="width: 100%;">
          <div slot="header" class="clearfix">
            <h2 class="post-title">{{ post.title }}</h2>
          </div>
          <div class="post-content">
            {{ post.articleAbstract }}
          </div>
          <div class="post-tags">
            <el-tag>java</el-tag>
            <el-tag>css</el-tag>
            <!--          <el-tag v-for="tag in post.tags" :key="tag" closable @close="handleClose(post, tag)">{{ tag }}</el-tag>-->
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>

</template>

<style scoped>
.zj-article-container {
  width: 80%;
  margin: 0 auto;
}

.demo-image__error .image-slot {
  font-size: 30px;
}
.demo-image__error .image-slot .el-icon {
  font-size: 30px;
}
.demo-image__error .el-image {
  width: 100%;
  height: 200px;
}

.post-card {
  width: 100%;
}

.post-image {
  width: 100%;
  height: auto;
  display: block;
}

.post-info-card {
  padding: 20px;
}

.post-title {
  margin-bottom: 10px;
}

.post-content {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  margin-bottom: 10px;
}

.post-tags {
  display: flex;
  flex-wrap: wrap;
}

.el-tag {
  margin-right: 5px;
  margin-bottom: 5px;
}
</style>
