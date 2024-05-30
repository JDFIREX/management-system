import { NextRequest } from "next/server"
import { withAuth } from "next-auth/middleware"
import createMiddleware from "next-intl/middleware"

export const runtime = "nodejs"

export default withAuth((request: NextRequest) => {
  const handleI18nRouting = createMiddleware({
    locales: ["pl", "en"],
    defaultLocale: "pl"
  })

  return handleI18nRouting(request)
})

export const config = {
  // Skip all paths that should not be internationalized. This example skips the
  // folders "api", "_next" and all files with an extension (e.g. favicon.ico)
  matcher: ["/((?!api|_next|.*\\..*).*)"]
}
