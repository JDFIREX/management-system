import NextAuth from "next-auth"
import KeycloakProvider from "next-auth/providers/keycloak";

const authOptions = {
  secret: process.env.NEXTAUTH_SECRET,
  providers: [
    KeycloakProvider({
      clientId: process.env.KEYCLOAK_ID as string,
      clientSecret: process.env.KEYCLOAK_SECRET as string,
      issuer: process.env.KEYCLOAK_ISSUER,
    })
  ]
}

const handler = NextAuth(authOptions)
export { handler as GET, handler as POST }
