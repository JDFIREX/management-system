import { FC } from "react"
import type { Metadata } from "next"

import { Theme } from "@radix-ui/themes"

import Sidebar from "./sidebar"

import "../globals.css"
import "@radix-ui/themes/styles.css"

export const metadata: Metadata = {
  title: "Create Next App",
  description: "Generated by create next app"
}

interface Props {
  children: React.ReactNode
  params: { locale: string }
}

const LocaleLayout: FC<Props> = (props) => {
  const { children, params } = props
  const { locale } = params

  return (
    <html lang={locale}>
      <body>
        <Theme>
          <Sidebar>{children}</Sidebar>
        </Theme>
      </body>
    </html>
  )
}

export default LocaleLayout
