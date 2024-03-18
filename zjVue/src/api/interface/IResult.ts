export interface IResult<T> {
    code: string
    message: string
    data?: T | any
}

export interface Page<T> {
    current: number,
    total: number,
    records?: T[]
}
