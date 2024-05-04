import { FC } from "react"

import { NavigationSidebar } from "@modules/navigation"
import { UserProfileSidebar } from "@modules/user"

interface Props {
  children: React.ReactNode
}

const Sidebar: FC<Props> = (props) => {
  const { children } = props

  return (
    <>
      <aside>
        <UserProfileSidebar />
        <NavigationSidebar />
      </aside>
      <main>{children}</main>
    </>
  )
}

export default Sidebar
