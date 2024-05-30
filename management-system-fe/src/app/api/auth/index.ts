import NextAuth, { CallbacksOptions } from "next-auth"
import KeycloakProvider from "next-auth/providers/keycloak"
import { SessionStrategy } from "next-auth/src/core/types"

export const authOptions = {
  secret: process.env.NEXTAUTH_SECRET,
  providers: [
    KeycloakProvider({
      clientId: process.env.KEYCLOAK_ID as string,
      clientSecret: process.env.KEYCLOAK_SECRET as string,
      issuer: process.env.KEYCLOAK_ISSUER
    })
  ],
  basePath: "/auth",
  session: {
    strategy: "jwt" as SessionStrategy
  },
  jwt: {
    secret: process.env.NEXTAUTH_SECRET as string
  },
  callbacks: {
    async session(props) {
      //console.log("session", props)
      const { session, token } = props
      session.token = token.token
      return session
    },
    async jwt(props) {
      //console.log("jwt", props)
      const { account, token } = props
      if (account && account.id_token) {
        token.token = account.id_token
      }
      return token
    }
  } as Partial<CallbacksOptions>,
  debug: true
}

export const handlers = NextAuth(authOptions)
