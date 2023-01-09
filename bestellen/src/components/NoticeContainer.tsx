import {useAppSelector} from "../app/hooks";
import {selectHidden, selectMessage} from "../features/notice/noticeSlice";
import styles from "../styles/General.module.scss"

export default function NoticeContainer(): JSX.Element {
    const message = useAppSelector(selectMessage)
    const hidden  = useAppSelector(selectHidden)
    return (
        <div hidden={hidden} className={styles.noticeContainer}>{message}</div>
    )
}
