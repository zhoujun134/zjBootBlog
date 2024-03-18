import request from "./service";
import type ILoginForm from "@/api/interface/user/ILoginForm";
import type IZjToken from "@/api/interface/token/Itoken";
import type {IResult} from "@/api/interface/IResult";

export function register(data: any) {
    return request({
        url: '/api/register/',
        method: 'post',
        data: data,
    }).then(res => {
        const registerResult = res.data as IResult<boolean>
        console.log("注册成功！res =" + JSON.stringify(res.data))
        if (registerResult.data) {

        }
    }).catch(error => {

    })
}

export async function login(data: ILoginForm): Promise<IResult<IZjToken>> {
    return await request.post<IResult<IZjToken>>("/api/login/", data)
        .then(resp => {
            const result: IResult<IZjToken> = JSON.parse(JSON.stringify(resp)) as IResult<IZjToken>
            console.log("result: " + JSON.stringify(result))
            console.log("333333  result.data= " + JSON.stringify(result.data))
            console.log("登录之后的 token: " + result.data.tokenName + " ===> " + result.data.tokenValue)
            localStorage.setItem(result.data.tokenName, JSON.stringify(result))
            return result;
        }).catch(error => {
            const res: IZjToken = {
                tokenName: "",
                tokenValue: "",
                tokenTimeout: 0,
                sessionTimeout: 0,
                loginId: ""
            };
            let {message} = error;
            console.log("调用登录接口 出现异常啦！message=" + message)
            return {
                code: "-1",
                message: message,
                data: res
            } as IResult<IZjToken>
        });
}

