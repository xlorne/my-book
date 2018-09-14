package com.codingapi.book.mybook.helper;

import com.codingapi.book.mybook.config.MyBookConfig;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Slf4j
@Component
public class GitHelper {

    @Autowired
    private MyBookConfig myBookConfig;

    public boolean download(){
        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider =new
                UsernamePasswordCredentialsProvider(myBookConfig.getGitUserName(),myBookConfig.getGitPassword());
        CloneCommand cloneCommand = Git.cloneRepository();
        try {
            Git git = cloneCommand.setURI(myBookConfig.getGitUrl())
                    .setBranch(myBookConfig.getGitBranch())
                    .setDirectory(new File(myBookConfig.getGitSavePath()))
                    .setCredentialsProvider(usernamePasswordCredentialsProvider)
                    .call();
            log.info("git-download-res->{}",git.tag());
            return true;
        }catch (Exception e){
            log.error(e.getLocalizedMessage(),e);
            return false;
        }
    }


    public void pull(){
        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider =new
                UsernamePasswordCredentialsProvider(myBookConfig.getGitUserName(),myBookConfig.getGitPassword());
        try {
            Git git = new Git(new FileRepository(myBookConfig.getGitSavePath()+"/.git"));
            git.pull().setRemoteBranchName(myBookConfig.getGitBranch())
                    .setCredentialsProvider(usernamePasswordCredentialsProvider).call();
            log.info("git-pull-res->{}",git.tag());
        }catch (Exception e){
            log.error(e.getLocalizedMessage(),e);
        }
    }

}
