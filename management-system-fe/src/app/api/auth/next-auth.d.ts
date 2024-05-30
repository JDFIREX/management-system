import { CustomAccount, CustomProfile } from "@/app/api/auth/next-auth-account"

declare module "next-auth" {
  export interface Session {
    user?: {
      name?: string | null
      email?: string | null
      image?: string | null
    }
    expires: string
    token: string
  }

  export interface Account extends CustomAccount {}
  export interface Profile extends CustomProfile {}
}

declare module "next-auth/jwt/types" {
  export interface JWT {
    name?: string | null
    email?: string | null
    picture?: string | null
    sub?: string
    nip: string
    given_name: string
    family_name: string
    token: string
    exp: number
    iat: number
    iss: string
    aud: string
    jti: string
    preferred_username: string
  }
}
