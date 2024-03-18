export interface IArticle {
    id: number,
    title: string,
    articleAbstract: string
    content: string,
    createTime: string
}

export interface ArticleListReq {
    pageNumber: number,
    pageSize: number
}
