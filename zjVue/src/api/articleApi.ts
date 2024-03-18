import request from "@/api/service";
import type {IResult, Page} from "@/api/interface/IResult";
import type {IArticle, ArticleListReq} from "@/api/interface/article/article";

export async function getArticleList(reqDto: ArticleListReq): Promise<IResult<Page<IArticle>>> {

    return await request({
        url: '/api/article/list',
        method: 'post',
        data: reqDto,
    }).then(resp => {
        const result: IResult<Page<IArticle>> = JSON.parse(JSON.stringify(resp)) as IResult<Page<IArticle>>
        console.log("获取到的结果为: result= " + JSON.stringify(result))
        return result;
    }).catch(error => {
        let {message} = error
        console.log("获取文章列表出现错误啦！" + message)
        return getDefaultPageIArticle(message)
    })
}

 export function getDefaultPageIArticle(message: string): IResult<Page<IArticle>> {
    const defaultPage: Page<IArticle> = {
        current: 1,
        total: 0
    } as Page<IArticle>;
    return {
        code: "0",
        message: message,
        data: defaultPage
    }
}
