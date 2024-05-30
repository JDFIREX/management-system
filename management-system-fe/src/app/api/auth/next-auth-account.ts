export interface CustomProfile {
  sub?: string
  name?: string
  preferred_username?: string
  email?: string
  image?: string
}

export interface CustomAccount {
  providerAccountId: string
  userId?: string
  provider: string
  type: "oauth" | "email" | "credentials"
  access_token?: string
  token_type?: string
  id_token?: string
  refresh_token?: string
  scope?: string
  expires_at?: number
  session_state?: string
  [key: string]: unknown
}
