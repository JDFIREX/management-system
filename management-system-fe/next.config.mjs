import createNextIntlPlugin from "next-intl/plugin"

const withNextIntl = createNextIntlPlugin("src/messages/i18n.ts")

/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  env: {
    NEXTAUTH_URL: 'http://localhost:3000',
    NEXTAUTH_SECRET: 'mQ46qpFwfE1BHuqMC+qlm19qBAD9fVPgh28werwe3ASFlAfnKjM=',
    KEYCLOAK_ID: 'management-system-fe',
    KEYCLOAK_SECRET: '7oHPVI3AEdyPgS6rgdOLNxudbmeGrGhR',
    KEYCLOAK_ISSUER: 'http://localhost:8088/realms/management-system',
  }
}

export default withNextIntl(nextConfig)
