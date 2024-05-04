import NextAuth from "next-auth"
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
  debug: false
}

export const handlers = NextAuth(authOptions)
