import createNextIntlPlugin from "next-intl/plugin"

const withNextIntl = createNextIntlPlugin("src/messages/i18n.ts")

/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true
}

export default withNextIntl(nextConfig)
