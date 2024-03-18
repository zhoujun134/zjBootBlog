<script setup lang="ts">

import {onMounted, ref} from "vue";
import type {ArticleListReq, IArticle} from "@/api/interface/article/article";
import type {Page} from "@/api/interface/IResult";
import {getArticleList, getDefaultPageIArticle} from "@/api/articleApi";
import MarkdownIt from "markdown-it";
import MarkdownItAnchor from "markdown-it-anchor";
import MarkdownItCodeCopy from "markdown-it-code-copy";
import MarkdownItAbbr from "markdown-it-abbr";
import MarkdownItFootnote from "markdown-it-footnote";
import MarkdownItHighlightjs from "markdown-it-highlightjs";
import MarkdownItSub from "markdown-it-sub";
import MarkdownItSup from "markdown-it-sup";
import MarkdownItTasklists from "markdown-it-task-lists";
import MarkdownItTOC from "markdown-it-toc-done-right";
const defaultOptions = {
  iconStyle: 'font-size: 50px; opacity: 0.4; color: black;',
  iconClass: 'zbus-daimawenjian',
  buttonStyle: 'position: absolute; top: 7.5px; right: 6px; cursor: pointer; outline: none; height: 20px; width: 50px;',
  buttonClass: 'zbus-daimawenjian'
};
const markdown = new MarkdownIt()
    .use(MarkdownItAbbr)
    .use(MarkdownItAnchor)
    .use(MarkdownItFootnote)
    .use(MarkdownItHighlightjs)
    .use(MarkdownItSub)
    .use(MarkdownItSup)
    .use(MarkdownItTasklists)
    .use(MarkdownItCodeCopy, defaultOptions)
    .use(MarkdownItTOC);


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

const codeHtml: string = " <div class='demo'>\n" +
    "        <p class='int'>hello Word</p>\n" +
    "</div>";

function articleList() {
  getArticleList(articleListReq.value).then(result => {
    const pageDataRes: Page<IArticle> = result.data
    console.log("pageDataRes: " + JSON.stringify(pageDataRes))
    articlePageInfo.value = pageDataRes;
  }).catch(error => {
    return getDefaultPageIArticle("获取页面文章出错了")
  })
}


const article = ref({
  id: 0,
  title: "",
  content: "",
  createTime: ""
} as IArticle)

onMounted(() => {
  articleList()
  setTimeout(() => {
    if (articlePageInfo.value.records) {
      article.value = articlePageInfo.value.records[0]
      console.log("article.value= " + JSON.stringify(article.value))
    }
  }, 500)
})

</script>

<template>
  <p>hello </p>
  <div>
    <highlightjs autodetect :code="codeHtml"/>
  </div>

  <i class="zbus-daimawenjian" style="color: black"></i>
  <div>
    接口获取
    <div v-html="markdown.render(article.content)"></div>
  </div>

</template>

<style scoped>

/* 为pre元素添加行号 */
pre {
  counter-reset: lineNumber;
}

/* 为pre下的每一个code行添加行号 */
pre > code .line {
  counter-increment: lineNumber;
}

/* 在每行代码前添加行号 */
pre > code .line::before {
  content: counter(lineNumber);
  display: inline-block;
  width: 3em;
  user-select: none;
  opacity: 0.5;
}

</style>
